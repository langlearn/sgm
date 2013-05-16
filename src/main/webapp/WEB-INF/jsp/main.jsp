<%--
  Created by IntelliJ IDEA.
  User: Yang
  Date: 13-5-8
  Time: 下午10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        .pan_body{
            overflow-y: hidden;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            var setting = {
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: function (event, treeId, treeNode) {
                        if ($('#tt').tabs('exists', treeNode.name)) {
                            $('#tt').tabs('select', treeNode.name);
                        } else {
                            $('#tt').tabs('add', {
                                title: treeNode.name,
                                content: '<iframe src="' + treeNode.src + '" style="height: 100%;width: 100%;border: 0px;"></iframe>',
                                closable: true,
                                bodyCls:'pan_body'
                            });
                        }
                    }
                }
            };

            var zNodes = [
                { id: 1, pId: 0, name: "项目管理", src: "project.do"},
                { id: 7, pId: 0, name: "工单管理", src: "workorder.do"},
                { id: 4, pId: 0, name: "工作日志", src: "workdiary.do"},
                { id: 5, pId: 0, name: "数据字典", src: "datadictionary.do"},
                { id: 6, pId: 0, name: "角色权限", src: "user.do"}
            ];

            $(document).ready(function () {
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            });
        });
    </script>
</head>
<body class="easyui-layout">
<div region="north" border="false" style="background:#666;text-align:center">
    <div id="header-inner">
        <table cellpadding="0" cellspacing="0" style="width:100%;">
            <tr>
                <td rowspan="2" style="width:20px;">
                </td>
                <td style="height:52px;">
                    <div style="color:#fff;font-size:22px;font-weight:bold;">
                        JEHR工时管理系统
                    </div>
                </td>
                <td style="padding-right:5px;text-align:right;vertical-align:bottom;">
                    <div id="topmenu" style="color:#fff;">
                        ${loginUser.truename}
                        ,<a href="login!loginOff.do">注销</a>
                    </div>
                </td>
            </tr>
        </table>
    </div>

</div>
<div region="west" border="false" split="true" title="功能菜单栏" style="width:250px;padding:5px;">
    <ul id="treeDemo" class="ztree"></ul>
</div>
<div region="center" border="false">
    <div id="tt" class="easyui-tabs" fit="true" border="false" plain="true">
        <div title="Welcome" fit="true" style="padding: 10px;">
        </div>
    </div>
</div>
</body>
</html>