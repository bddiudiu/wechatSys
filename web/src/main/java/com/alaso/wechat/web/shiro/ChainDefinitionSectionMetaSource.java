package com.alaso.wechat.web.shiro;

import com.alaso.wechat.server.dao.PermissionMapper;
import com.alaso.wechat.server.entity.Permission;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adam on 23/2/16.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

    public static int i;

    // shiro默认的链接定义 写在xml上的。
    private String filterChainDefinitions;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 通过filterChainDefinitions对默认的链接过滤定义
     *
     * @param filterChainDefinitions
     *            默认的接过滤定义
     */
    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public Ini.Section getObject() throws Exception {
        Ini ini = new Ini();
        // 加载默认的url
        ini.load(filterChainDefinitions);
        System.out.println(filterChainDefinitions);
		/*1加载类似以下的信息
		  	/login.do = authc
	        /favicon.ico = anon
	        /logout.do = logout
	        /selectOption.do = roles[index]
	        /index.jsp = perms[index:index]
			/testDwr.jsp = perms[index:testdwr]

	         2
	         	循环数据库资源的url
	        for (Resource resource : resourceDao.getAll()) {
	if(StringUtils.isNotEmpty(resource.getValue()) && StringUtils.isNotEmpty(resource.getPermission())) {
	        		section.put(resource.getValue(), resource.getPermission());
	        	}
	        }
			加载数据库t_permission 的 value 和 permission组成类似1的格式 ，
			若要这样使用， permission 需要--->  perms[permission]

		 */
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        //查询数据库中  路径对应需要的权限.
        List<Permission> lst = permissionMapper.queryPermissions();
        for(Permission per : lst){
            //访问某一路径，需要对应的权限
            section.put(per.getUrl(), "perms["+per.getRole()+"]");

        }
        //section.put("/testDwr.jsp", "perms[index:testdwr]");///testDwr.jsp = perms[index:testdwr]

		/*//因为顺序原因, 把/**放到最后
		 *   [上面的覆盖下面的]
		 *  把("/**", "authc") 放在  ("/testDwr.jsp", "perms[index:testdwr]")  上面,
		 *  /testDwr.jsp 就只需要登录, 不需要perms[index:testdwr]权限了
		 */
        section.put("/**", "anon");
        for(String s : section.keySet()){
            System.out.println(s + "----"+ section.get(s)+"--------22222---section");
        }
        System.out.println("11111111111111111111111");

        return section;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
