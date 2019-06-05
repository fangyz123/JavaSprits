package team.javaSpirit.teachingAssistantPlatform;

public class Screenshot {

	public Screenshot() {
		// TODO Auto-generated constructor stub
	//}

	/*
	 * 我以前做过一个保存为avi的； 代码如下：
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
//	//AVI准备   
//	CString   szText;   
//	HRESULT   hr;   
//	WORD   wVer;   
//	CString   szMessage;   
//
//	//确认Video版本必须为1.1     
//	wVer   =   HIWORD(VideoForWindowsVersion());   
//	if   (wVer   <   0x010a){   
//	//错误信息提示   
//	m_AviFileName   =   "错误信息提示:";   
//	szMessage   =   "版本太旧！";   
//	MessageBeep(MB_ICONHAND);   
//	MessageBox(szMessage,   m_AviFileName,   MB_OK|MB_ICONSTOP);   
//	return;   
//	}   
//
//	//系统函数,AVI初始化   
//	AVIFileInit();   
//	//AVI视频流指针初始化   
//	recorder.ps =   NULL;   
//	recorder.psCompressed =   NULL;   
//	//AVI视频流文件初始化   
//	recorder.pfile =   NULL;   
//	//设置帧计数器   
//	recorder.lPageNum =   0;   
//	//定义AVI文件名,可从用户界面输入(现在已从前面文件对话框中输入)   
//	//szTitle="Output.avi";  
//	//打开AVI文件   
//
//	hr=AVIFileOpen(&recorder.pfile,(LPCTSTR)m_AviFileName,OF_WRITE|OF_CREATE,NULL);
//	if   (hr   !=   AVIERR_OK)   
//	recorder.VideoRecordEnd();   //如果AVI文件打开错误则录制结束   ************/
//	//录象开始标志   
//	recorder.bVideoRecord   =   TRUE;   
//	//刷新窗口,这时OnDraw()进行不断刷新,开始录制AVI   
//	Invalidate(FALSE);   
//	}
//
//	void CRecord::AVI_Recorde(CDC *pDC)
//	{
//	glReadPixels(0,0,alpbi->biWidth,alpbi->biHeight,GL_BGR_EXT,GL_UNSIGNED_BYTE,(unsigned   char   *)alpbi+40);  
//	    
//	//对于首帧图象的处理，把图象信息写入AVI文件头内；其他帧写入视频流   
//	if(lPageNum   ==   0)   WriteAVIHead(); //写AVI文件头       
//	else WriteAVIStream(); //写AVI视频流  
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
//	//在OnDraw()中作用，表示下次将写入AVI文件流   
//	lPageNum++;   
//
//	//设置AVI视频流信息   
//	memset(&strhdr,  0, sizeof(strhdr));   
//	strhdr.fccType = streamtypeVIDEO; //视频流信息   
//	strhdr.fccHandler =   0;   
//	strhdr.dwScale  =   1; //变比   
//	strhdr.dwRate =  20;// Avi_Rate; //AVI播放速度，在界面中输入 ******************/  
//	strhdr.dwSuggestedBufferSize     =   alpbi->biSizeImage;   
//	SetRect(&strhdr.rcFrame,   0,   0, //输入AVI每帧图象的尺寸   
//	(int)   alpbi->biWidth,   
//	(int)   alpbi->biHeight);   
//	//建 new stream in an existing file and creates an interface to the new stream.   
//	hr   =   AVIFileCreateStream(pfile,         //   文件指针   
//	&ps, //   流指针   
//	&strhdr); //   视频流头信息   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd();  /***************************/
//	//设置AVI选项，选择压缩类型   
//	memset(&opts,   0,   sizeof(opts));  
//
//	opts.fccHandler   =   0x6376736d;   
//	opts.dwQuality   =  8000;     //100%   quality,   9000   would   be   90%,    
//	opts.dwFlags   =   8;   
//	opts.lpParms   =   (LPVOID   *)GlobalAlloc(NULL,   4);   
//	opts.cbParms   =   4;   
//	*((long*)opts.lpParms)   =   75;   
//
//	//由于该函数不能在已启动定时器Timer下作用，只能在启动定时器前使用，否则内存冲突   
//	//因此这里不调用该函数，视频压缩采用缺省值，为非压缩视频   
//	//if   (!AVISaveOptions(NULL,   0,   1,   &ps,   (LPAVICOMPRESSOPTIONS   FAR   *)   &aopts))   
////	         OnVideoRecordEnd();
//
//	//压缩视频流   
//	hr   =   AVIMakeCompressedStream(&psCompressed,   ps,   &opts,   NULL);   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd();  
//	//设置视频流格式   
//	hr   =   AVIStreamSetFormat(psCompressed,   0,   
//	alpbi,   
//	alpbi->biSize   +       
//	alpbi->biClrUsed   *   sizeof(RGBQUAD));   
//	if   (hr   !=   AVIERR_OK)   VideoRecordEnd(); 
//	}
//
//	// 写AVI视频流
//	void   CRecord::WriteAVIStream()   
//	{   
//	HRESULT   hr;   
//
//	//写视频流   
//	hr   =   AVIStreamWrite(psCompressed, //   视频流指针   
//	(lPageNum-1)   *   1, //   当前帧的时间   
//	//   因为计数从0开始，而在WriteAVIHead()中m_PageNum已加1，所以这里减1   
//	1, //   写入的帧数   
//	(LPBYTE)   alpbi   + //   指向位图帧的指针   
//	alpbi->biSize   +   
//	alpbi->biClrUsed   *   sizeof(RGBQUAD),   
//	alpbi->biSizeImage, //   该帧图象的大小   
//	AVIIF_KEYFRAME, //   该帧作为关键帧   
//	NULL,   
//	NULL);   
//
//	//帧计数器加1   
//	lPageNum++;   
//
//	if   (hr   !=   AVIERR_OK)   return;   
//
//	}
//
//	// 停止录制AVI
//	void   CRecord::VideoRecordEnd()     
	//{   
	//录像结束标志   
	//bVideoRecord   =   FALSE;   
	// lPageNum   =   0;   
	//删除已申请的内存指针   
	/*delete   pBitmap;   
	delete   pMemDC;   
	pBitmap   =   NULL;   
	pMemDC     =   NULL;   */
	//   关闭AVI视频流指针   
	//if   (ps) AVIStreamClose(ps);   
	//if   (psCompressed)   AVIStreamClose(psCompressed);   
	//关闭AVI文件指针   
	//if   (pfile)   AVIFileClose(pfile);   
	//退出AVI文件   
	//AVIFileExit();   
	}

}
