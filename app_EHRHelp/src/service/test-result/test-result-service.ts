import { Http,Util } from '@/utils';
import TestResultServiceBase from './test-result-service-base';


/**
 * 测评结果摘要信息服务对象
 *
 * @export
 * @class TestResultService
 * @extends {TestResultServiceBase}
 */
export default class TestResultService extends TestResultServiceBase {

    /**
     * Creates an instance of  TestResultService.
     * 
     * @param {*} [opts={}]
     * @memberof  TestResultService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}