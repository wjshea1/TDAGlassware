<article><section><table class=\"align-justify\"><tbody><#list research.quotes.indices as index><tr><td>${index.Symbol}</td><td>${index.Last}</td> <td style=\"color: <#if (index.ChangePct <0 )>red<#else>green</#if>\" >${index.Change} (${index.ChangePct}%)</td></tr></#list></tbody></table></section></article>