<#import "../common.ftl" as common>

<@common.page "Tachers">
    <#if deleted?? && deleted.name??>
        <div class="alert alert-danger my-3">Teacher '${deleted.name}' deleted successfully</div>
    </#if>

    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Department</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.department.name}</td>
                <td><a class="m-1 btn btn-outline-primary" href="/teachers/edit?id=${item.id}">Edit</a></td>
                <td>
                    <form class="form-inline m-1" action="/teachers/delete?id=${item.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-outline-danger" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@common.page>