import { Http } from './../http/http';
import { Subject } from 'rxjs';

/**
 * 计数器对象
 *
 * @export
 * @class UICounter
 */
export class UICounter {

    /**
     * 定时器时间
     * 
     * @private
     * @type {*}
     * @memberof UICounter
     */
    private timer: number;

    /**
     * 定时器
     * 
     * @private
     * @type {*}
     * @memberof UICounter
     */
    private timerTag: any = null;

    /**
     * 计数器id
     * 
     * @private
     * @type {*}
     * @memberof UICounter
     */
    private counterId: string = '';

    /**
     * 计数器交互数据
     *
     * @private
     * @type {*}
     * @memberof UICounter
     */
    private data: any = {};

    /**
     * url
     *
     * @type {string}
     * @memberof UICounter
     */
    public url: string = '';

    /**
     * 请求
     *
     * @private
     * @type {Http}
     * @memberof UICounter
     */
    private http: Http = Http.getInstance();

    /**
     * 计数器对象订阅对象
     *
     * @type {Subject<any>}
     * @memberof UICounter
     */
    public uiCounterData: Subject<any> = new Subject();

    /**
     * Creates an instance of UICounter.
     * 创建 UICounter 服务对象
     * 
     * @param {*} [config={}]
     * @memberof UICounter
     */
    constructor(config: any = {}) {
        this.counterId = config.counterId;
        this.timer = config.timer;
        this.url = config.url;
        this.load();
    }

    /**
     * 加载定时器
     * 
     * @memberof UICounter
     */
    private load(): void {
        if (this.timer > 1000) {
            this.timerTag = setInterval(() => {
                this.reload();
            }, this.timer);
        }
        this.reload();
    }

    /**
     * 刷新计数器
     * 
     * @private
     * @param {*} [arg={}] 
     * @memberof UICounter
     */
    public reload(arg: any = {}): void {
        this.http.get(this.url).then((response: any) => {
            if (!response || response.status !== 200) {
                return;
            }

            const { data: result }= response;
            this.setData(result);
        }).catch((response: any) => {
        });
    }

    /**
     * 处理数据
     * 
     * @private
     * @param {*} result 
     * @memberof UICounter
     */
    private setData(result: any): void {
        this.data = result;
        this.uiCounterData.next(this.data);
    }

    /**
     * 获取数据
     * 
     * @returns {*} 
     * @memberof UICounter
     */
    public getData(): any {
        return this.data;
    }

    /**
     * 关闭计数器
     * 
     * @memberof UICounter
     */
    public close(): void {
        if (this.timerTag !== undefined) {
            clearInterval(this.timerTag);
            delete this.timer;
        }
    }
}