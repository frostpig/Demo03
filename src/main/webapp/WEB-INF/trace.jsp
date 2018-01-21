<%--
  Created by IntelliJ IDEA.
  User: frostpig
  Date: 2017/11/26
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>TreeGrid Actions - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/css/easyui.css">
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
</head>
<body>
<h2>TreeGrid Actions</h2>
<p>Click the buttons below to perform actions.</p>
<div style="margin:20px 0;">
<%--    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="collapseAll()">CollapseAll</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="expandAll()">ExpandAll</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="expandTo()">ExpandTo</a>--%>
</div>
<table id="tg" class="easyui-treegrid" title="TreeGrid Actions" style="width:700px;height:250px"
       data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: true,
				url: '/user/check1',
				method: 'get',
				idField: 'id',
				treeField: 'name',
				onClickRow: function(row){
                       getDetail(row);
                    }
			">
    <thead>
    <tr>
        <th data-options="field:'name',width:180">Task Name</th>
        <th data-options="field:'persons',width:60,align:'right'">Persons</th>
        <th data-options="field:'begin',width:80">Begin Date</th>
        <th data-options="field:'end',width:80">End Date</th>
        <th data-options="field:'详情',width:120">异常</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    function formatProgress(value) {
        /*if (value) {
            var s = '<div style="width:100%;border:1px solid #ccc">' +
                '<div style="width:' + value + '%;background:#cc0000;color:#fff">' + value + '%' + '</div>'
            '</div>';
            return s;
        } else {
            return '';
        }*/
        var s = '<a href="index.jsp" style="color: #0e90d2">+value+</a>';
        return s;
    }

   function getDetail(row) {
//      alert(row);
       console.log(row);
       $('#tg').treegrid('insert', {
           after: row.id,
           /*data: {
               id: 38,
               name: 'name38'
           }*/
           iconCls: 'icon-ok',
           rownumbers: true,
           animate: true,
           collapsible: true,
           fitColumns: true,
           url: '/user/check1',
           method: 'get',
           idField: 'id',
           columns:[[
               {title:'Task Name',field:'name',width:180},
               {field:'persons',title:'Persons',width:60,align:'right'},
               {field:'begin',title:'Begin Date',width:80},
               {field:'end',title:'End Date',width:80},
               {field:'详情',title:'End Date',width:80}
           ]]
       });
   }





/*
    function collapseAll() {
        $('#tg').treegrid('collapseAll');
    }

    function expandAll() {
        $('#tg').treegrid('expandAll');
    }

    function expandTo() {
        $('#tg').treegrid('expandTo', 21).treegrid('select', 21);
    }*/
</script>
</body>

</html>
