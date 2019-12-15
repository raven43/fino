<#import "../common.ftl" as common>

<@common.page "Edit Teacher">
    <#if saved?? && saved.name??>
        <div class="alert alert-info my-3">Teacher '${saved.name}' saved successfully</div>
    </#if>

    <form method="post" class="m-2 needs-validation" enctype="multipart/form-data" novalidate>
        <div class="form-group">
            <label for="name">Teacher Name</label>
            <input name="name" id="name" placeholder="Teacher name..." class="form-control" type="text" maxlength="100"
                   <#if item?? && item.name??>value="${item.name}"</#if> required>
        </div>
        <div class="form-group">
            <label for="departmentId">Department</label>
            <select name="departmentId" id="departmentId" class="form-control" required>
                <option value="" disabled>Select Type...</option>
                <#list departments as department>
                    <option value="${department.id}">${department.shortName}</option>
                </#list>
            </select>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</@common.page>