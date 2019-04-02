public aspect TraceAsoect_Marupov {
	
	pointcut classToTrace(): within(ComponentApp) || within(DataApp) || within(ServiceApp);
	
	pointcut constructorToTrace(): classToTrace() && execution(new(..));
	
	pointcut methodToTrace() : classToTrace() && execution(String area(String));
	
	
	before(): methodToTrace() {
		System.out.println("-->"
				+ thisJoinPointStaticPart.getSignature() 
				+ ", "+ thisJoinPointStaticPart.getKind() 
				+ ", "+ thisJoinPointStaticPart.getSourceLocation().getFileName() 
				+ ", "+ thisJoinPointStaticPart.getSourceLocation().getWithinType() 
				+ ", "+ thisJoinPointStaticPart.getSourceLocation().getLine());
		}
	
	after(): methodToTrace() {		
		System.out.println(" Another info is: "+ thisJoinPointStaticPart.getSignature());		
	}
}
