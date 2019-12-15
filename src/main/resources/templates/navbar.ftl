<#include "security.ftl">

<header class="navbar-light bg-light mb-3">
    <nav class="navbar navbar-expand-md  mb-3 mx-auto" style="max-width: 1000px">
        <a class="navbar-brand" href="/">BSUIR</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">

            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="/">Home</a>
                <a class="nav-item nav-link" href="/departments">Departments</a>
                <a class="nav-item nav-link" href="/departments/edit">Add Department</a>
                <a class="nav-item nav-link" href="/teachers">Teachers</a>
                <a class="nav-item nav-link" href="/teachers/edit">Add Teacher</a>
                <a class="nav-item nav-link" href="/disciplines">Disciplines</a>
                <a class="nav-item nav-link" href="/disciplines/edit">Add Discipline</a>

                <#if isAuthorize>
                    <span class="nav-item nav-link">${user.username}</span>
                    <form class="form-inline ml-2 float-right" action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-outline-danger" type="submit">Sign Out</button>
                    </form>
                <#else>
                    <div class="form-inline mr-2 ">
                        <a class="btn btn-outline-success" href="/login">Log in</a>
                    </div>
                    <div class="form-inline mr-2 float-right">
                        <a class="btn btn-outline-info" href="/register">Register</a>
                    </div>
                </#if>
            </div>
        </div>
    </nav>
</header>
