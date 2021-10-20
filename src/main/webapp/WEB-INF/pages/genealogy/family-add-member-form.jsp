<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../../fragments/header.jsp" flush="true"/>

<section id="banner">
    <div class="content">
<%--        <span class="image object avatar-middle">--%>
<%--            <img src="../../../resources/img/anonymous/man.jpg" alt="Photo" class="avatar-middle">--%>
<%--        </span>--%>

        <div class="content">
        <form:form method="post" modelAttribute="userProfileNewFamilyMember">

            <table>
                <tr>
                    <td>
                        <select name="idSelectedUserProfile">
                            <c:forEach var="singleUserProfile" items="${allUserProfile}">
                                <option value="${singleUserProfile.id}">
                                        ${singleUserProfile.name.lastName}
                                        ${singleUserProfile.name.firstName}
                                        ${singleUserProfile.name.middleName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>
                        <select name="idSelectedFamilyTies">
                            <c:forEach var="singleFamilyTies" items="${listFamilyTies}">
                                <option value="${singleFamilyTies.id}">${singleFamilyTies.nameFamilyTies}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

            </table>

            <form:hidden path="id"/>
            <form:hidden path="registered"/>
            <form:hidden path="updated"/>
            <form:hidden path="user.id"/>
            <form:hidden path="userPhotoList" id="userPhotoListFormId"/>

            <label for="image_uploads">Choose images to upload (PNG, JPG)</label>
            <input type="file" id="image_uploads" name="image_uploads" accept=".jpg, .jpeg, .png" multiple>

            <div class="preview">
                <p>No files currently selected for upload</p>
            </div>
<%--            <label onclick="updateImageDisplay()">add photo</label>--%>

<%--            <script type="text/javascript">--%>
<%--                const input = document.querySelector('#image_uploads');--%>
<%--                const preview = document.querySelector('.preview');--%>

<%--                input.style.opacity = 0;--%>

<%--                input.addEventListener('change', updateImageDisplay);--%>

<%--                function updateImageDisplay() {--%>
<%--                    while(preview.firstChild) {--%>
<%--                        preview.removeChild(preview.firstChild);--%>
<%--                    }--%>

<%--                    const curFiles = input.files;--%>
<%--                    if(curFiles.length === 0) {--%>
<%--                        const para = document.createElement('p');--%>
<%--                        para.textContent = 'No files currently selected for upload';--%>
<%--                        preview.appendChild(para);--%>
<%--                    } else {--%>
<%--                        const list = document.createElement('ol');--%>
<%--                        preview.appendChild(list);--%>

<%--                        for(const file of curFiles) {--%>
<%--                            const listItem = document.createElement('li');--%>
<%--                            const para = document.createElement('p');--%>
<%--                            if(validFileType(file)) {--%>
<%--                                para.textContent = `File name ${file.name}, file size .`;--%>
<%--                                const image = document.createElement('img');--%>
<%--                                image.src = URL.createObjectURL(file);--%>

<%--                                listItem.appendChild(image);--%>
<%--                                listItem.appendChild(para);--%>
<%--                            } else {--%>
<%--                                para.textContent = `File name ${file.name}: Not a valid file type. Update your selection.`;--%>
<%--                                listItem.appendChild(para);--%>
<%--                            }--%>

<%--                            list.appendChild(listItem);--%>
<%--                        }--%>
<%--                    }--%>
<%--                }--%>

<%--                const fileTypes = [--%>
<%--                    "image/apng",--%>
<%--                    "image/bmp",--%>
<%--                    "image/gif",--%>
<%--                    "image/jpeg",--%>
<%--                    "image/pjpeg",--%>
<%--                    "image/png",--%>
<%--                    "image/svg+xml",--%>
<%--                    "image/tiff",--%>
<%--                    "image/webp",--%>
<%--                    "image/x-icon"--%>
<%--                ];--%>

<%--                function validFileType(file) {--%>
<%--                    return fileTypes.includes(file.type);--%>
<%--                }--%>

<%--                function returnFileSize(number) {--%>
<%--                    if(number < 1024) {--%>
<%--                        return number + 'bytes';--%>
<%--                    } else if(number >= 1024 && number < 1048576) {--%>
<%--                        return (number/1024).toFixed(1) + 'KB';--%>
<%--                    } else if(number >= 1048576) {--%>
<%--                        return (number/1048576).toFixed(1) + 'MB';--%>
<%--                    }--%>
<%--                }--%>
<%--            </script>--%>
<%--            <input name="image" type="file" id="fileName" accept="image/*" onchange="addImageToList()"/>--%>
<%--            <script type="text/javascript">--%>
<%--                // function validateFileType(){--%>
<%--                //     let fileName = document.getElementById("fileName").value;--%>
<%--                //     let idxDot = fileName.lastIndexOf(".") + 1;--%>
<%--                //     let extFile = fileName.substr(idxDot, fileName.length).toLowerCase();--%>
<%--                //     if (extFile==="jpg" || extFile==="jpeg" || extFile==="png"){--%>
<%--                //         //TO DO--%>
<%--                //     }else{--%>
<%--                //         alert("Only jpg/jpeg and png files are allowed!");--%>
<%--                //     }--%>
<%--                // }--%>
<%--                function validateFileType() {--%>
<%--                    const imageInput = document.getElementById("fileName").value;--%>
<%--                    if (imageInput.files[0]) {--%>
<%--                        alert('imageInput.files[0]');--%>
<%--                        let file = imageInput.files[0];--%>
<%--                        let pattern = /image-*/;--%>

<%--                        if (!file.type.match(pattern)) {--%>
<%--                            return false;--%>
<%--                        }--%>
<%--                        return true;--%>
<%--                    }--%>
<%--                }--%>
<%--                function addImageToList() {--%>
<%--                    if (validateFileType()) {--%>
<%--                        console.log(document.getElementById("userPhotoListFormId").nodeValue);--%>
<%--                    } else {--%>
<%--                        alert('Invalid format');--%>
<%--                    }--%>
<%--                }--%>
<%--            </script>--%>


            <%--        <img src="../../../resources/img/anonymous/man.jpg">--%>

            <%--        Firstname: --%>
            <form:input path="name.firstName" accesskey="hvj" title="Firstname"/>
            <form:errors path="name.firstName"/> <br>
            Lastname: <form:input path="name.lastName"/>
            <form:errors path="name.lastName"/> <br>
            Middle name: <form:input path="name.middleName"/>
            <form:errors path="name.middleName"/> <br>

            Sex: <form:radiobuttons path="sex"/>
            <form:errors path="sex"/> <br>

            dateOfBirth: <form:input type="date" path="dateOfBirth"/>
            <form:errors path="dateOfBirth"/>

            dateOfDeath: <form:input type="date" path="dateOfDeath"/>
            <form:errors path="dateOfDeath"/> <br>

            placeOfBirth: <form:input path="placeOfBirth"/>
            <form:errors path="placeOfBirth"/> <br>

            <input type="submit">

        </form:form>
        </div>
    </div>
</section>

<jsp:include page="../../fragments/footer.jsp" flush="true"/>