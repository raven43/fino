<#import "../common.ftl" as common>

<@common.page "Edit Discipline">
    <#if saved?? && saved.name??>
        <div class="alert alert-info my-3">Teacher '${saved.name}' saved successfully</div>
    </#if>

    <form method="post" class="m-2 needs-validation" enctype="multipart/form-data" novalidate>
        <div class="form-group">
            <label for="name">Discipline Name</label>
            <input name="name" id="name" placeholder="Discipline name..." class="form-control" type="text"
                   maxlength="100"
                   <#if item?? && item.name??>value="${item.name}"</#if> required>
        </div>
        <div class="form-group">
            <label for="hours">Hours</label>
            <input name="hours" id="hours" class="form-control" type="number" min="0"
                   <#if item?? && item.hours??>value="${item.hours}"</#if> required>
        </div>
        <div class="form-group">
            <label for="departmentId">Department</label>
            <select name="teacherId" id="teacherId" class="form-control" required>
                <option value="" disabled>Select Teacher...</option>
                <#list teachers as teacher>
                    <option value="${teacher.id}">${teacher.name}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="test">Test</label>
            <input name="test" id="test" class="form-control" type="checkbox"
                   <#if item?? && item.test>checked</#if>>
        </div>
        <div class="form-group">
            <label for="exam">Exam</label>
            <input name="exam" id="exam" class="form-control" type="checkbox"
                   <#if item?? && item.exam>checked</#if>>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</@common.page>