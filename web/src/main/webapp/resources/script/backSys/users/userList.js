$(function(){
    //初始化用户列表表格
    initUserListTable();
});

function initUserListTable(){
    $('#userListTable').bootstrapTable({
        pagination: true,
        search: true,
        searchAlign:'right',
        //height:450,
        url:'user/queryUsers',
        toolbar:'#newServiceConfigure',
        toolbarAlign:'left',
        clickToSelect:true,
        striped:true,
        pageSize:8,
        pageList : [ 'all' ],
        columns: [{
            field: 'state',
            checkbox:true,
        },
            {
                field: 'id',
                title: '用户ID',
                width:200,
                align:'center',
                valign:'middle'
            }, {
                field: 'nikeName',
                title: '用户昵称',
                align:'center',
                width:170,
                valign:'middle'
            }, {
                field: 'email',
                title: '邮箱',
                align:'center',
                valign:'middle',
                width:200,
            }, {
                field: 'control',
                title: '操作',
                align:'center',
                valign:'middle',
                formatter:function(value,row){
                    var buttons='';
                    buttons=buttons.concat('<a class="btn btn-primary" style="width:80px;height:30px;padding-top:4px;" href="modifyUser/'+ row.id+'" name="btn" class="btn btn-primary btn-sm">编辑</a>&nbsp');
                    return buttons;
                }
            }
        ],
    });

    $('#userListTable').find('.no-records-found td').
    css("height",$('#userListTable').parent().height()-30+'px').
    css("line-height",$('#userListTable').parent().height()-18+'px').css('color','red');
}

function addUsers(){
    window.location="/user/addUserPage";
}