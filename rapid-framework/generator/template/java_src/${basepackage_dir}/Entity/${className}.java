<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.Entity;
import java.util.*;
import java.io.Serializable;
import javax.persistence.*;
<#include "/java_imports.include">

@Entity
@Table(name = "${table.sqlName}")
public class ${className} implements Serializable{

<@generateFields/>
<@generateRelations/>
<@generateProperties/>

}

<#macro generateRelations>

<#if table.exportedKeys.getSize() gt 0>
	/**	表关联部分代码*/
<#list table.exportedKeys.listMapToList() as t>

	private List<${t.getClassName()}>  ${t.getClassNameFirstLower()}s;

	public List<${t.getClassName()}>  get${t.getClassName()}s() {		return this.${t.getClassNameFirstLower()}s;		}

	public void set${t.getClassName()}s(List<${t.getClassName()}> value) {		this.${t.getClassNameFirstLower()}s = value;	}
</#list>
	/**	表关联部分代码*/

<#else>
	/**	无关联部分代码*/
</#if>
</#macro>
<#macro generateFields>
<#list table.columns as column>
	/** ${column.columnAlias} */
 	private ${column.javaType} ${column.columnNameLower};
 </#list>
</#macro>

<#macro generateProperties>
<#list table.columns as column>
<#if column.isStringColumn>
	@Column(name = "${column.columnName}", nullable = ${column.nullable?string('true','false')}, insertable = ${column.insertable?string('true','false')}, updatable = ${column.updatable?string('true','false')}, length = ${column.getSize()})
<#else>
	@Column(name = "${column.columnName}", nullable = ${column.nullable?string('true','false')}, insertable = ${column.insertable?string('true','false')}, updatable = ${column.updatable?string('true','false')})
</#if>
	public ${column.javaType} get${column.columnName}() {		return this.${column.columnNameLower};		}

	public void set${column.columnName}(${column.javaType} value) {		this.${column.columnNameLower} = value;		}
</#list>
</#macro>



