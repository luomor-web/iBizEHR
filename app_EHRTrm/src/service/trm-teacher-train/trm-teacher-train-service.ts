import { Http,Util } from '@/utils';
import TrmTeacherTrainServiceBase from './trm-teacher-train-service-base';


/**
 * 讲师授课记录服务对象
 *
 * @export
 * @class TrmTeacherTrainService
 * @extends {TrmTeacherTrainServiceBase}
 */
export default class TrmTeacherTrainService extends TrmTeacherTrainServiceBase {

    /**
     * Creates an instance of  TrmTeacherTrainService.
     * 
     * @param {*} [opts={}]
     * @memberof  TrmTeacherTrainService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}