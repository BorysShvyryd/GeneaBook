<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<div class="row gtr-200">
    <section>
        <div class="row gtr-200">
            <div class="col-6 col-12-medium">
                <c:choose>
                    <c:when test="${empty mainPhoto}">
                        <p>
                            <span class="image left">
                                <c:choose>
                                    <c:when test="${userProfile.sex == 'MALE'}">
                                        <img src="../../../resources/img/anonymous/man.png">
                                    </c:when>
                                    <c:when test="${userProfile.sex == 'FEMALE'}">
                                        <img src="../../../resources/img/anonymous/woman.png">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="../../../resources/img/anonymous/unknown.png">
                                    </c:otherwise>
                                </c:choose>
                            </span>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p>
                        <h4>${mainPhoto.name}</h4>
                        <span class="image left">
                                    <img src="../../../resources/img/saved.png" alt="Main images">
                                    <%-- <img src="data:image/gif;base64,<%= imgDataBase64 %>" alt="images Here"/>--%>
                        </span>
                        ${mainPhoto.description}
                        </p>

                    </c:otherwise>
                </c:choose>

                <div class="box alt">
                    <div class="row gtr-50 gtr-uniform" id="imageList">
                        <c:forEach var="photo" items="${userProfile.userPhotoList}">
                            <div class="col-2" id="imgListPreview">
                                        <span class="image fit">
<%--                                            ${photo.userImage.length()}--%>
                                            <img src="${(window.URL ? URL : webkitURL).createObjectURL(photo.userImage)}" alt="Photo">
<%--                                            <img src="../../../resources/img/anonymous/unknown.png" alt="Photo">--%>
                                        </span>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div>
                    <c:if test="${not readOnly}">

                        <label for="add_to_list">Add image</label>
                        <input type="file" id="add_to_list" accept=".jpg, .jpeg, .png"
                               multiple="" style="opacity: 0;">

                    </c:if>
                </div>

                <c:if test="${not readOnly}">
                    <script type="text/javascript">
                        document.addEventListener("DOMContentLoaded", function (event) {

                            const input = document.getElementById('add_to_list');
                            const image_list = document.getElementById('imageList');

                            <%--for (let i = 0; i <= "${userProfile.userPhotoList.size()}"; i++) {--%>
                            <%--    const listItem = document.createElement('div');--%>
                            <%--    listItem.classList.add('col-2');--%>
                            <%--    image_list.appendChild(listItem);--%>
                            <%--//--%>
                            <%--    const spanImageEl = document.createElement('span');--%>
                            <%--    spanImageEl.classList.add('image','fit');--%>
                            <%--    listItem.appendChild(spanImageEl);--%>
                            <%--//--%>
                            <%--    const image = document.createElement('img');--%>
                            <%--    image.src = URL.createObjectURL("${userProfile.userPhotoList.get(0).userImage}");--%>
                            <%--//--%>
                            <%--    spanImageEl.appendChild(image);--%>
                            <%--}--%>

                            input.addEventListener('change', addImageToList);

                            function addImageToList() {

                                const currentFiles = input.files;
                                if (currentFiles.length === 0) {
                                    alert('No files currently selected for upload');
                                } else {

                                    for (const file of currentFiles) {

                                        if (validFileType(file)) {
                                            const listItem = document.createElement('div');
                                            listItem.classList.add('col-2');
                                            image_list.appendChild(listItem);

                                            const spanImageEl = document.createElement('span');
                                            spanImageEl.classList.add('image','fit');
                                            listItem.appendChild(spanImageEl);

                                            const image = document.createElement('img');
                                            image.src = URL.createObjectURL(file);

                                            spanImageEl.appendChild(image);

                                            <%--let addd = "${userProfile.userPhotoList.add()}";--%>
                                        } else {
                                            alert('File name ${file.name}: Not a valid file type. Update your selection.');
                                        }
                                    }
                                }
                            }

                        });

                        const fileTypes = [
                            "image/apng",
                            "image/bmp",
                            "image/gif",
                            "image/jpeg",
                            "image/pjpeg",
                            "image/png",
                            "image/svg+xml",
                            "image/tiff",
                            "image/webp",
                            "image/x-icon"
                        ];

                        function validFileType(file) {
                            return fileTypes.includes(file.type);
                        }
                    </script>
                </c:if>

            </div>

            <div class="col-6 col-12-medium">
                <c:choose>
                    <c:when test="${readOnly}">
                        <h2>View profile</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>Edit profile</h2>
                    </c:otherwise>
                </c:choose>

                <form:form method="post" modelAttribute="userProfile">
                    <div class="row gtr-uniform">
                        <div class="col-12">
                            <form:hidden path="id"/>
                            <form:hidden path="registered"/>
                            <form:hidden path="updated"/>
                            <form:hidden path="user.id"/>
                            <form:hidden path="userPhotoList"/>
                            <form:hidden path="relationships"/>
                        </div>
                        <div class="col-12">
                            <label>Firstname:
                                <form:input path="name.firstName" disabled="${readOnly}"/>
                                <form:errors path="name.firstName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Lastname:
                                <form:input path="name.lastName" disabled="${readOnly}"/>
                                <form:errors path="name.lastName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Middle name:
                                <form:input path="name.middleName" disabled="${readOnly}"/>
                                <form:errors path="name.middleName"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Sex:
                                <form:radiobuttons path="sex" disabled="${readOnly}"/>
                                <form:errors path="sex"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>Date of birth:
                                <form:input type="date" path="dateOfBirth" disabled="${readOnly}"/>
                                <form:errors path="dateOfBirth"/>
                            </label>
                            <c:if test="${not readOnly || (not empty userProfile.dateOfDeath)}">
                                <label>Date of death:
                                    <form:input type="date" path="dateOfDeath" disabled="${readOnly}"/>
                                    <form:errors path="dateOfDeath"/>
                                </label>
                            </c:if>
                        </div>

                        <div class="col-12">
                            <label>Place of birth:
                                <form:input path="placeOfBirth" disabled="${readOnly}"/>
                                <form:errors path="placeOfBirth"/>
                            </label>
                        </div>
                        <div class="col-12">
                            <c:choose>
                                <c:when test="${readOnly}">
                                    <input type="submit" value="Return">
                                    <button type="reset"
                                            onclick="javascript:window.location.href='/genealogy/family/edit-profile?id=${userProfile.id}'">
                                        Edit
                                    </button>
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="Save">
                                    <button type="reset" onclick="javascript:history.go(-1)">Return</button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
    </section>
</div>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>