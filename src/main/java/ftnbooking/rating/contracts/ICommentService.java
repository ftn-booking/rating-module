package ftnbooking.rating.contracts;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
//@SOAPBinding(style = Style.RPC)
@SOAPBinding(style = Style.DOCUMENT)
public interface ICommentService {

	@WebMethod boolean HasProfanities(String commentContent);
	@WebMethod void AddProfanity(String profanity);
	@WebMethod void RemoveProfanity(String profanity);
}
