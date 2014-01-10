<#function gainlosscolor change>
	<#if (change < 0) >
		<# return "color:red" />
	</#if>
	<#if (change > 0) >
		<# return "color:green" />
	</#if>
	<#if (change==0) >
		<# return "color:white"/>
	</#if>
</#function>
<article><section><table class="align-justify"><tbody><#list research.quotes.indices as index><tr><td>${index.Symbol}</td><td>${index.Last}</td> <td style=${gainlosscolor(index.Change)}>${index.Change} (${index.ChangePct}%)</td></tr></#list></tbody></table></section></article>