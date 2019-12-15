<#import "../common.ftl" as common>

<@common.page "Edit Department">

    <#if saved?? && saved.name??>
        <div class="alert alert-info my-3">Department '${saved.name}' saved successfully</div>
    </#if>

    <form method="post" class="m-2 needs-validation" enctype="multipart/form-data" novalidate>
        <div class="form-group">
            <label for="name">Department Name</label>
            <input name="name" id="name" placeholder="Department name..." class="form-control" type="text" maxlength="100"
                   <#if item?? && item.name??>value="${item.name}"</#if> required>
        </div>
        <div class="form-group">
            <label for="shortName">Department Short Name</label>
            <input name="shortName" id="shortName" placeholder="Department Short name..." class="form-control" type="text" maxlength="100"
                   <#if item?? && item.shortName??>value="${item.shortName}"</#if> required>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</@common.page>