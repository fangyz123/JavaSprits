package team.javaSpirit.teachingAssistantPlatform;

public class Screenshot {

	public Screenshot() {
		// TODO Auto-generated constructor stub
	//}

	/*
	 * ����ǰ����һ������Ϊavi�ģ� �������£�
	 */
//	public void OnVideoRecordBegin()
//	{
//	recorder.bVideoRecord=TRUE;
//	m_VideoBegin=TRUE;
//	HANDLE   hDIB;   
//	int   lC,lR;   
//	CRect lpRect;
//	this->GetWindowRect(lpRect);
//	recorder.WinViewX=lpRect.Width();
//	recorder.WinViewY=lpRect.Height();
//
//	lC   =   (recorder.WinViewX/4)*4;   
//	lR   =   recorder.WinViewY;   
//	hDIB   =   (HANDLE)   ::GlobalAlloc(GHND,lC*lR*3+44);   
//	recorder.alpbi   =   (LPBITMAPINFOHEADER)   ::GlobalLock((HGLOBAL)   hDIB);   
//	recorder.alpbi->biBitCount   =   24;   
//	recorder.alpbi->biClrImportant   =   0;   
//	recorder.alpbi->biClrUsed   =   0;   
//	recorder.alpbi->biCompression   =   0;   
//	recorder.alpbi->biHeight   =   lR;   
//	recorder.alpbi->biPlanes   =   1;   
//	recorder.alpbi->biSize   =   40;   
//	recorder.alpbi->biSizeImage   =   lC*lR*3;   
//	recorder.alpbi->biWidth   =   lC;   
//	recorder.alpbi->biXPelsPerMeter   =   1;   
//	recorder.alpbi->biYPelsPerMeter   =   1;   
//
//
//	//AVI׼��   
//	CString   szText;   
//	HRESULT   hr;   
//	WORD   wVer;   
//	CString   szMessage;   
//
//	//ȷ��Video�汾����Ϊ1.1     
//	wVer   =   HIWORD(VideoForWindowsVersion());   
//	if   (wVer   <   0x010a){   
//	//������Ϣ��ʾ   
//	m_AviFileName   =   "������Ϣ��ʾ:";   
//	szMessage   =   "�汾̫�ɣ�";   
//	MessageBeep(MB_ICONHAND);   
//	MessageBox(szMessage,   m_AviFileName,   MB_OK|MB_ICONSTOP);   
//	return;   
//	}   
//
//	//ϵͳ����,AVI��ʼ��   
//	AVIFileInit();   
//	//AVI��Ƶ��ָ���ʼ��   
//	recorder.ps =   NULL;   
//	recorder.psCompressed =   NULL;   
//	//AVI��Ƶ���ļ���ʼ��   
//	recorder.pfile =   NULL;   
//	//����֡������   
//	recorder.lPageNum =   0;   
//	//����AVI�ļ���,�ɴ��û���������(�����Ѵ�ǰ���ļ��Ի���������)   
//	//szTitle="Output.avi";  
//	//��AVI�ļ�   
//
//	hr=AVIFileOpen(&recorder.pfile,(LPCTSTR)m_AviFileName,OF_WRITE|OF_CREATE,NULL);
//	if   (hr   !=   AVIERR_OK)   
//	recorder.VideoRecordEnd();   //���AVI�ļ��򿪴�����¼�ƽ���   ************/
//	//¼��ʼ��־   
//	recorder.bVideoRecord   =   TRUE;   
//	//ˢ�´���,��ʱOnDraw()���в���ˢ��,��ʼ¼��AVI   
//	Invalidate(FALSE);   
//	}
//
//	void CRecord::AVI_Recorde(CDC *pDC)
//	{
//	glReadPixels(0,0,alpbi->biWidth,alpbi->biHeight,GL_BGR_EXT,GL_UNSIGNED_BYTE,(unsigned   char   *)alpbi+40);  
//	    
//	//������֡ͼ��Ĵ�����ͼ����Ϣд��AVI�ļ�ͷ�ڣ�����֡д����Ƶ��   
//	if(lPageNum   ==   0)   WriteAVIHead(); //дAVI�ļ�ͷ       
//	else WriteAVIStream(); //дAVI��Ƶ��  
//
//	}
//
//	void CRecord::WriteAVIHead(void)
//	{
//	AVISTREAMINFO   strhdr;   
//	AVICOMPRESSOPTIONS   opts;   
//	AVICOMPRESSOPTIONS   FAR   *   aopts[1]   =   {&opts};   
//	HRESULT   hr;   
//
//	//��OnDraw()�����ã���ʾ�´ν�д��AVI�ļ���   
//	lPageNum++;   
//
//	//����AVI��Ƶ����Ϣ   
//	memset(&strhdr,  0, sizeof(strhdr));   
//	strhdr.fccType = streamtypeVIDEO; //��Ƶ����Ϣ   
//	strhdr.fccHandler =   0;   
//	strhdr.dwScale  =   1; //���   
//	strhdr.dwRate =  20;// Avi_Rate; //AVI�����ٶȣ��ڽ��������� ******************/  
//	strhdr.dwSuggestedBufferSize     =   alpbi->biSizeImage;   
//	SetRect(&strhdr.rcFrame,   0,   0, //����AVIÿ֡ͼ��ĳߴ�   
//	(int)   alpbi->biWidth,   
//	(int)   alpbi->biHeight);   
//	//�� new stream in an existing file and creates an interface to the new stream.   
//	hr   =   AVIFileCreateStream(pfile,         //   �ļ�ָ��   
//	&ps, //   ��ָ��   
//	&strhdr); //   ��Ƶ��ͷ��Ϣ   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd();  /***************************/
//	//����AVIѡ�ѡ��ѹ������   
//	memset(&opts,   0,   sizeof(opts));  
//
//	opts.fccHandler   =   0x6376736d;   
//	opts.dwQuality   =  8000;     //100%   quality,   9000   would   be   90%,    
//	opts.dwFlags   =   8;   
//	opts.lpParms   =   (LPVOID   *)GlobalAlloc(NULL,   4);   
//	opts.cbParms   =   4;   
//	*((long*)opts.lpParms)   =   75;   
//
//	//���ڸú�����������������ʱ��Timer�����ã�ֻ����������ʱ��ǰʹ�ã������ڴ��ͻ   
//	//������ﲻ���øú�������Ƶѹ������ȱʡֵ��Ϊ��ѹ����Ƶ   
//	//if   (!AVISaveOptions(NULL,   0,   1,   &ps,   (LPAVICOMPRESSOPTIONS   FAR   *)   &aopts))   
////	         OnVideoRecordEnd();
//
//	//ѹ����Ƶ��   
//	hr   =   AVIMakeCompressedStream(&psCompressed,   ps,   &opts,   NULL);   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd();  
//	//������Ƶ����ʽ   
//	hr   =   AVIStreamSetFormat(psCompressed,   0,   
//	alpbi,   
//	alpbi->biSize   +       
//	alpbi->biClrUsed   *   sizeof(RGBQUAD));   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd(); 
//	}
//
//	// дAVI��Ƶ��
//	void   CRecord::WriteAVIStream()   
//	{   
//	HRESULT   hr;   
//
//	//д��Ƶ��   
//	hr   =   AVIStreamWrite(psCompressed, //   ��Ƶ��ָ��   
//	(lPageNum-1)   *   1, //   ��ǰ֡��ʱ��   
//	//   ��Ϊ������0��ʼ������WriteAVIHead()��m_PageNum�Ѽ�1�����������1   
//	1, //   д���֡��   
//	(LPBYTE)   alpbi   + //   ָ��λͼ֡��ָ��   
//	alpbi->biSize   +   
//	alpbi->biClrUsed   *   sizeof(RGBQUAD),   
//	alpbi->biSizeImage, //   ��֡ͼ��Ĵ�С   
//	AVIIF_KEYFRAME, //   ��֡��Ϊ�ؼ�֡   
//	NULL,   
//	NULL);   
//
//	//֡��������1   
//	lPageNum++;   
//
//	if   (hr   !=   AVIERR_OK)   return;   
//
//	}
//
//	// ֹͣ¼��AVI
//	void   CRecord::VideoRecordEnd()     
	//{   
	//¼�������־   
	//bVideoRecord   =   FALSE;   
	// lPageNum   =   0;   
	//ɾ����������ڴ�ָ��   
	/*delete   pBitmap;   
	delete   pMemDC;   
	pBitmap   =   NULL;   
	pMemDC     =   NULL;   */
	//   �ر�AVI��Ƶ��ָ��   
	//if   (ps) AVIStreamClose(ps);   
	//if   (psCompressed)   AVIStreamClose(psCompressed);   
	//�ر�AVI�ļ�ָ��   
	//if   (pfile)   AVIFileClose(pfile);   
	//�˳�AVI�ļ�   
	//AVIFileExit();   
	}

}
