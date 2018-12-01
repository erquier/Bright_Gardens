<div id="navbar" class="sombra">
    <a>jhsdfasdahigadbh</a>
    <a>jhsdfasdahigadbh</a>
    <a>jhsdfasdahigadbh</a>
    <a>jhsdfasdahigadbh</a>
</div>




























<div id="sidebar" class="sombra">



<img class="sombra" src="https://images.unsplash.com/photo-1512546148165-e50d714a565a?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=98956e751d3438525d047729d5f497d7&auto">




    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">

            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>

    </g:each>





</div>





