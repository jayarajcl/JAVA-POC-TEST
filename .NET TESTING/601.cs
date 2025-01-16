using System;
using System.Web;
using System.Collections.Generic;

public class UnvalidatedUrlHandler : IHttpHandler
{
    private List<string> VALID_REDIRECTS = new List<string>{};

    public void ProcessRequest(HttpContext ctx)
    {
        if (VALID_REDIRECTS.Contains(ctx.Request.QueryString["page"]))
        {
            ctx.Response.Redirect(ctx.Request.QueryString["page"]);
        }
    }
}