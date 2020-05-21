import { Http,Util } from '@/utils';
import WXMediaServiceBase from './wxmedia-service-base';


/**
 * 微信多媒体内容服务对象
 *
 * @export
 * @class WXMediaService
 * @extends {WXMediaServiceBase}
 */
export default class WXMediaService extends WXMediaServiceBase {

    /**
     * Creates an instance of  WXMediaService.
     * 
     * @param {*} [opts={}]
     * @memberof  WXMediaService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}