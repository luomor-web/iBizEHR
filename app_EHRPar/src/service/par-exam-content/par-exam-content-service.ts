import { Http,Util } from '@/utils';
import ParExamContentServiceBase from './par-exam-content-service-base';


/**
 * 考核内容服务对象
 *
 * @export
 * @class ParExamContentService
 * @extends {ParExamContentServiceBase}
 */
export default class ParExamContentService extends ParExamContentServiceBase {

    /**
     * Creates an instance of  ParExamContentService.
     * 
     * @param {*} [opts={}]
     * @memberof  ParExamContentService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}