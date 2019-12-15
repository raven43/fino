<#import "../common.ftl" as common>

<@common.page "Disciplines">
    <#if deleted?? && deleted.name??>
        <div class="alert alert-danger my-3">Discipline '${deleted.name}' deleted successfully</div>
    </#if>

    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Hours</td>
            <td>Test</td>
            <td>Exam</td>
            <td>Teacher</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.hours} h</td>
                <td>${item.test?string("true","false")}</td>
                <td>${item.exam?string("true","false")}</td>
                <td>${item.teacher.name}</td>
                <td><a class="btn btn-outline-primary m-1" href="/disciplines/edit?id=${item.id}">Edit</a></td>
                <td>
                    <form class="form-inline m-1" action="/disciplines/delete?id=${item.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-outline-danger" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@common.page>