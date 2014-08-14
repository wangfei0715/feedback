/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

//CKEDITOR.editorConfig = function( config )
//{
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
//};

CKEDITOR.editorConfig = function( config ) 
{ 
// Define changes to default configuration here. For example: 
config.language = 'zh-cn'; //配置语言 
//config.uiColor = '#FFF'; //背景颜色 
config.width = 525; //宽度 
config.height = 150; //高度 
//config.skin='v2'; //设置编辑器的风格 
//工具栏 
config.toolbar = 
[ 
['Source'], 
['Cut','Copy','Paste','PasteText','PasteFromWord'], 
['Bold','Italic','Underline','Strike','-','Subscript','Superscript'], 
['TextColor','BGColor'], 
] 
};
