<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<%--<script src="https://d3js.org/d3.v7.min.js"></script>--%>

<%--<link rel="stylesheet" href="../../../resources/js/fam/jquery-ui-1.10.2.custom.css"/>--%>
<%--<script type="text/javascript" src="../../../resources/js/fam/jquery-1.9.1.js"></script>--%>
<%--<script type="text/javascript" src="../../../resources/js/fam/jquery-ui-1.10.2.custom.min.js"></script>--%>
<%----%>
<%--<script type="text/javascript" src="../../../resources/js/fam/primitives.min.js?2020"></script>--%>
<%--<link href="../../../resources/js/fam/primitives.latest.css?2020" media="screen" rel="stylesheet" type="text/css"/>--%>
<%--<script type="text/javascript" src="../../../resources/js/fam/myfamily.js"></script>--%>
<%--<script src="../../../resources/js/fam/jquery.ui.touch-punch.min.js"></script>--%>
<%----%>
<%--<style>--%>
<%--    #draggable { cursor: help; }--%>
<%--</style>--%>
<%----%>
<%--<script>--%>
<%--    $(function () {--%>
<%--        $("#draggable").draggable();--%>
<%--    });--%>
<%--</script>--%>

<input type="hidden" id="wewe" name="myFamilyData" value="${myFamily}">

<c:forEach var="singleFamilyMember" items="${myFamily}">
    <div>
        <a href="/genealogy/family/view-profile?id=${singleFamilyMember.id}">
                ${singleFamilyMember.name.firstName}
                ${singleFamilyMember.name.lastName}
                ${singleFamilyMember.name.middleName}
        </a>
    </div>
</c:forEach>

<%--<script type="text/javascript">--%>
<%--    console.log(document.getElementById("wewe").value);--%>
<%--</script>--%>

<%--<script type="text/javascript">--%>
<%--    jQuery(document).ready(function () {--%>
<%--        let options = new primitives.orgdiagram.Config();--%>
<%----%>
<%--        options.items = famdata; //document.getElementById("wewe").value;--%>
<%--        console.log(items.length);--%>
<%----%>
<%--        options.cursorItem = null;--%>
<%----%>
<%--        options.hasSelectorCheckbox = primitives.common.Enabled.False;--%>
<%--        options.hasButtons = primitives.common.Enabled.False;--%>
<%--        options.pageFitMode = primitives.common.PageFitMode.PrintPreview;--%>
<%--        options.elbowType = primitives.common.ElbowType.Round;--%>
<%--        options.normalLevelShift = 20;--%>
<%--        options.dotLevelShift = 20;--%>
<%--        options.lineLevelShift = 24;--%>
<%--        options.normalItemsInterval = 10;--%>
<%--        options.dotItemsInterval = 1;--%>
<%--        options.lineItemsInterval = 1;--%>
<%--        options.linesWidth = 1;--%>
<%--        options.linesColor = "#7C8993";--%>
<%----%>
<%--        jQuery("#diagram").famDiagram(options);--%>
<%----%>
<%--        let placeholder = jQuery(".placeholder");--%>
<%--        jQuery("#diagram").css({--%>
<%--            width: placeholder.width() + 10,--%>
<%--            height: placeholder.height() + 10,--%>
<%--        })--%>
<%--        jQuery("#diagram").famDiagram("update");--%>
<%----%>
<%--    });--%>
<%----%>
<%--</script>--%>
<%--</head>--%>

<%--FAMILY TREE<br>--%>


<%--<div class="container">--%>
<%--    <div id="draggable" class="ui-widget-content ui-draggable">--%>
<%--        <div id="diagram" style="width:80%; height:80%"></div>--%>
<%--    </div>--%>
<%--</div>--%>

<!-- Search -->
<%--        <section id="search" class="alt">--%>
<%--            <form method="post" action="#">--%>
<%--                <input type="text" name="query" id="query" placeholder="Search" />--%>
<%--            </form>--%>
<%--        </section>--%>


<%--current family member: ${userIdRelation.name.firstName} ${userIdRelation.name.lastName}<br>--%>

<%--<svg width = "500" height = "500">--%>
<%--    <rect x = "0" y = "0" width = "300" height = "200" fill = "yellow">--%>
<%--        <c:forEach var="singleFamilyMember" items="${myFamily}">--%>
<%--        <div>--%>
<%--                ${singleFamilyMember.name.firstName}--%>
<%--                ${singleFamilyMember.name.lastName}--%>
<%--                ${singleFamilyMember.name.middleName}--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--    </rect>--%>
<%--</svg>--%>

<%--<ul id = "list">--%>
<%--    <li></li>--%>
<%--    <li></li>--%>
<%--</ul>--%>

<%--<input type = "button" name = "remove" value = "Remove fourth value"--%>
<%--       onclick = "javascript:remove()" />--%>

<%--<script>--%>
<%--    let data = document.getElementById("wewe").value;--%>
<%--    d3.select("#list").selectAll("li")--%>
<%--        .data(data)--%>
<%--        .text(function(d)--%>
<%--        { return "This is pre-existing element and the value is " + d; })--%>
<%--        .enter()--%>
<%--        .append("li")--%>
<%--        .text(function(d)--%>
<%--        { return "This is dynamically created element and the value is " + d; });--%>

<%--    function remove() {--%>
<%--        d3.selectAll("li")--%>
<%--            .data([10, 20, 30, 15])--%>
<%--            .exit()--%>
<%--            .remove()--%>
<%--    }--%>
<%--</script>--%>

<%--<a href="/genealogy/family/add-family-member">view family tree</a>--%>
<a href="/genealogy/family/add-family-member">add family member</a>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
