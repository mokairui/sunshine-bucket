package ${packageName};

<#list importList as importObj>
<#nt>import ${importObj};
</#list>

public class ${className} implements ${interfaceName} {

    @Override
    public ${returnType} ${methodName}(<#list parameters as param>${param} ${param?uncap_first}</#list>) {
        return null;
    }

}
