public class XMLHandler : IHttpHandler
{
    public void ProcessRequest(HttpContext ctx)
    {
        XmlReaderSettings settings = new XmlReaderSettings()
        {
            DtdProcessing = DtdProcessing.Prohibit
        };
        XmlReader reader = XmlReader.Create(ctx.Request.QueryString["document"], settings);
    ...
  }
}