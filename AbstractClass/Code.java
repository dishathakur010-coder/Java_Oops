abstract class AbstractAssessmentFlow{
    public final void executeAssessment(){
        validate();
        prepare();
        evaluate();
        publishResult();
    }
    protected void validate(){
        System.out.println("Validation done");
    }
    protected void prepare(){
        System.out.println("Preparation done");
    }
    protected abstract void evaluate();
    protected void publishResult(){
        System.out.println("Result published");
    }
}
interface AutoAssessment{
    default void evaluate(){
        System.out.println("Auto evaluation logic executed");
    }
}
interface ManualAssessment{
    default void evaluate(){
        System.out.println("Manual evaluation logic executed");
    }
}
public class UnifiedAssessmentExecutor extends AbstractAssessmentFlow implements AutoAssessment,ManualAssessment{
    private boolean isProctored;
    public UnifiedAssessmentExecutor(boolean isProctored){
        this.isProctored=isProctored;
    }
    protected void evaluate(){
        if(isProctored){
            AutoAssessment.super.evaluate();
        } 
        else{
            ManualAssessment.super.evaluate();
        }
    }
}
