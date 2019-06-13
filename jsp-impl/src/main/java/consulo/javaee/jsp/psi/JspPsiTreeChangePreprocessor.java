package consulo.javaee.jsp.psi;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.PsiModificationTrackerImpl;
import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.impl.PsiTreeChangePreprocessorBase;
import com.intellij.psi.impl.source.jsp.jspXml.JspDirective;
import com.intellij.psi.jsp.JspFile;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * @author VISTALL
 * @since 23-Jun-17
 */
public class JspPsiTreeChangePreprocessor extends PsiTreeChangePreprocessorBase
{
	@Inject
	public JspPsiTreeChangePreprocessor(@Nonnull PsiManager psiManager)
	{
		super(psiManager);
	}

	@Override
	protected boolean acceptsEvent(@Nonnull PsiTreeChangeEventImpl event)
	{
		return event.getFile() instanceof JspFile;
	}

	@Override
	protected boolean isOutOfCodeBlock(@Nonnull PsiElement element)
	{
		if(PsiTreeUtil.getParentOfType(element, JspDirective.class) != null)
		{
			return true;
		}
		return false;
	}

	@Override
	protected void doIncOutOfCodeBlockCounter()
	{
		((PsiModificationTrackerImpl) myPsiManager.getModificationTracker()).incCounter();
	}
}