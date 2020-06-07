<template>
  <textarea :id="id"></textarea>
</template>
<script lang = 'ts'>
import { Vue, Component, Prop, Model, Watch } from 'vue-property-decorator';
import { Subject } from 'rxjs';
import { Environment } from '@/environments/environment';
import axios from 'axios';

import tinymce from "tinymce/tinymce";
import 'tinymce/themes/modern';
import 'tinymce/plugins/link';
import 'tinymce/plugins/paste';
import 'tinymce/plugins/table';
import 'tinymce/plugins/image';
import 'tinymce/plugins/imagetools';
import 'tinymce/plugins/codesample';
import 'tinymce/plugins/code';
import 'tinymce/plugins/fullscreen';
import 'tinymce/plugins/preview';

const tinymceCode:any = tinymce;



@Component({})
export default class AppRichTextEditor extends Vue {

    /**
     * 传入值
     * 
     * @type {*}
     * @memberof AppRichTextEditor
     */
    @Prop() value?: any;
    
    /**
     * 输入name
     * 
     * @type {string}
     * @memberof AppRichTextEditor
     */
    @Prop() name?: string;

    /**
     * 输入高度
     * 
     * @type {*}
     * @memberof AppRichTextEditor
     */
    @Prop() height?: any;

    /**
     * 是否禁用
     * 
     * @type {boolean}
     * @memberof AppRichTextEditor
     */
    @Prop() disabled?: boolean;

    /**
     * 表单状态
     *
     * @type {Subject<any>}
     * @memberof AppRichTextEditor
     */
    @Prop() public formState?: Subject<any>;

    /**
     * 上传文件路径
     * 
     * @type {string}
     * @memberof AppRichTextEditor
     */
    public uploadUrl = Environment.BaseUrl + Environment.UploadFile;

    /**
     * 下载路径
     * 
     * @type {string}
     * @memberof AppRichTextEditor
     */
    public downloadUrl =  Environment.BaseUrl + Environment.ExportFile;

    /**
     * 当前富文本
     * 
     * @type {*}
     * @memberof AppRichTextEditor
     */
    public editor: any = null;

    /**
     *  当前富文本id
     * 
     * @type {string}
     * @memberof AppRichTextEditor
     */
    public id: string = this.$util.createUUID();

    /**
     * 当前语言,默认中文
     * 
     * @type {*}
     * @memberof AppRichTextEditor
     */
    public langu: any = localStorage.getItem('local') ? localStorage.getItem('local') : 'zh-CN' ;
    
    /**
     * 语言映射文件
     * 
     * @type {*}
     * @memberof AppRichTextEditor
     */
    public languMap:any = {
        'zh-CN': 'zh_CN',
        'en-US': 'en_US',
    };

    /**
     * 是否处于激活状态
     * 
     * @type {boolean}
     * @memberof AppRichTextEditor
     */
    public isActived:boolean = true;

    /**
     * 是否需要初始化
     * 
     * @type {boolean}
     * @memberof AppRichTextEditor
     */
    public isNeedInit:boolean = false;

    /**
     * 生命周期
     *
     * @memberof AppRichTextEditor
     */
    public created() {
        if(this.formState) {
            this.formState.subscribe(({ type, data }) => {
                if (Object.is('load', type)) {
                    if (!this.value) {
                        this.init();
                    }
                }
            });
        }
    }
    
    /**
     * 生命周期：激活
     *
     * @memberof AppRichTextEditor
     */
    public activated(){
        this.isActived = true;
        if(this.isNeedInit){
            this.init();
            this.isNeedInit = false;
        }
    }

    /**
     * 生命周期：缓存
     *
     * @memberof AppRichTextEditor
     */
    public deactivated(){
        this.isActived = false;
    }

    /**
     * 生命周期：初始化富文本
     * 
     * @memberof AppRichTextEditor
     */
    public mounted() {
        this.init();
    }
    
    /**
     * 生命周期：销毁富文本
     * 
     * @memberof AppRichTextEditor
     */
    public destoryed(){
        if(this.editor){
            tinymceCode.remove('#' + this.id);
        }
    }

    /**
     * 监听value值
     * 
     * @memberof AppRichTextEditor
     */
    @Watch('value', { immediate: true, deep: true })
    oncurrentContent(newval: any, val: any) {
        if (newval) {
            this.init();
        }
    }

    /**
     * 监听语言变化
     */
    @Watch('$i18n.locale')
    onLocaleChange(newval: any, val: any) {
        this.langu = newval;
        if(this.isActived){
            this.init();
        }else{
            this.isNeedInit = true;
        }
    }

    /**
     * 初始化富文本
     * 
     * @memberof AppRichTextEditor
     */
    public init() {
        this.destoryed();
        let richtexteditor = this;
        tinymceCode.init({
            selector: '#' + richtexteditor.id,
            width: 'calc( 100% - 2px )',
            height: richtexteditor.height,
            min_height: 400,
            branding: false,
            plugins: ['link', 'paste', 'table', 'image', 'codesample', 'code', 'fullscreen', 'preview'],
            codesample_languages: [
                { text: 'HTML/XML', value: 'markup' },
                { text: 'JavaScript', value: 'javascript' },
                { text: 'CSS', value: 'css' },
                { text: 'PHP', value: 'php' },
                { text: 'Ruby', value: 'ruby' },
                { text: 'Python', value: 'python' },
                { text: 'Java', value: 'java' },
                { text: 'C', value: 'c' },
                { text: 'C#', value: 'csharp' },
                { text: 'C++', value: 'cpp' }
            ],
            paste_data_images: true,
            codesample_content_css: 'assets/tinymce/prism.css',
            skin_url: './assets/tinymce/skins/lightgray',
            language_url: './assets/tinymce/langs/' + richtexteditor.languMap[richtexteditor.langu] + '.js',
            language:richtexteditor.languMap[richtexteditor.langu],
            setup: (editor: any) => {
                richtexteditor.editor = editor;
                editor.on('blur', () => {
                    const content = editor.getContent();
                    richtexteditor.$emit('change', content);
                });
            },
            images_upload_handler: (bolbinfo: any, success: any, failure: any) => {
                const formData = new FormData();
                formData.append('file', bolbinfo.blob(), bolbinfo.filename());
                const _url = richtexteditor.uploadUrl;
                richtexteditor.uploadFile(_url, formData).subscribe((file: any) => {
                    if (file.filename) {
                        const id: string = file.fileid;
                        const url: string = `${richtexteditor.downloadUrl}/${id}`
                        success(url);
                    }
                }, (error: any) => {
                    console.log(error);
                    failure('HTTP Error: ' + error.status);
                });
            },
            init_instance_callback: (editor: any) => {
                richtexteditor.editor = editor;
                let value = (richtexteditor.value && richtexteditor.value.length > 0) ? richtexteditor.value : '';
                if (richtexteditor.editor) {
                    richtexteditor.editor.setContent(value);
                }
                if (richtexteditor.disabled) {
                    richtexteditor.editor.setMode('readonly');
                }
            }
        });
    }

    /**
     * 上传文件
     * 
     * @param url 路径
     * @param formData 文件对象 
     * @memberof AppRichTextEditor
     */
    public uploadFile(url: string, formData: any) {
        let _this = this;
        const subject: Subject<any> = new Subject<any>();
        axios({
            method: 'post',
            url: url,
            data: formData,
            headers: { 'Content-Type': 'image/png', 'Accept': 'application/json' },
        }).then((response: any) => {
            if (response.status === 200) {
                subject.next(response.data);
            } else {
                subject.error(response);
            }
        }).catch((response: any) => {
            subject.error(response);
        });
        return subject;
    }
}
</script>
<style lang="less">
@import './app-rich-text-editor.less';
</style>