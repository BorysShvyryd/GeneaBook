<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <div class="row gtr-200">
            <h2>Family tree</h2>
            <div class="col-6 col-12-medium">
                <div class="col-12">

                    <%--                    <input type="hidden" id="wewe" name="myFamilyData" value="${myFamily}">--%>

                    <c:forEach var="singleFamilyMember" items="${myFamily}">
                        <a href="/genealogy/family/view-profile?id=${singleFamilyMember.id}">
                            <div class="box">
                                <p>
                                        ${singleFamilyMember.name.firstName}
                                        ${singleFamilyMember.name.lastName}
                                        ${singleFamilyMember.name.middleName}
                                </p>
                                <p>
                                        ${singleFamilyMember.dateOfBirth}

                                    <c:if test="${not empty singleFamilyMember.dateOfDeath}">
                                        ${singleFamilyMember.dateOfDeath}
                                    </c:if>
                                </p>
                            </div>

                        </a>
                        <%--    <div>--%>
                        <%--        <c:forEach var="relationship" items="${singleFamilyMember.relationships}">--%>
                        <%--            ${relationship.userWho}--%>
                        <%--            ${relationship.nameFamilyTies.nameFamilyTies}--%>
                        <%--            ${relationship.userWhom}--%>
                        <%--        </c:forEach>--%>
                        <%--&lt;%&ndash;            ${singleFamilyMember.relationships}&ndash;%&gt;--%>
                        <%--    </div>--%>
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

                    <p></p>
                    <button onclick="window.location.href='/genealogy/family/add-family-member'">
                        add family member
                    </button>
                </div>
            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>
