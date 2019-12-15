<#import "../common.ftl" as common>

<@common.page "Departments">

    <#if deleted?? && deleted.name??>
        <div class="alert alert-danger my-3">Department '${deleted.name}' deleted successfully</div>
    </#if>

    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Short Name</td>
            <td>Name</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.shortName}</td>
                <td>${item.name}</td>
                <td>
                    <a class="btn btn-outline-primary m-1" href="/departments/edit?id=${item.id}">Edit</a>
                </td>
                <td>
                    <form class="form-inline m-1" action="/departments/delete?id=${item.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-outline-danger" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@common.page>