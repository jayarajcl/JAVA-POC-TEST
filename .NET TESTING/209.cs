using System;
using System.Web;
using System.IO;

public class StackTraceHandler : IHttpHandler
{

    public void ProcessRequest(HttpContext ctx)
    {
        try
        {
            doSomeWork();
        }
        catch (Exception ex)
        {
            File.WriteAllText("error_log.txt", ex.ToString());
            ctx.Response.Redirect("ErrorPage.aspx");
        }
    }
}