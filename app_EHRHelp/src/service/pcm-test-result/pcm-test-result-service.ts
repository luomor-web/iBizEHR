import { Http,Util } from '@/utils';
import PcmTestResultServiceBase from './pcm-test-result-service-base';


/**
 * 测评结果摘要信息服务对象
 *
 * @export
 * @class PcmTestResultService
 * @extends {PcmTestResultServiceBase}
 */
export default class PcmTestResultService extends PcmTestResultServiceBase {

    /**
     * Creates an instance of  PcmTestResultService.
     * 
     * @param {*} [opts={}]
     * @memberof  PcmTestResultService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}