/**
 * KQSZTreeExpViewtreeexpbar 部件模型
 *
 * @export
 * @class KQSZTreeExpViewtreeexpbarModel
 */
export default class KQSZTreeExpViewtreeexpbarModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof KQSZTreeExpViewtreeexpbarModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'createman',
      },
      {
        name: 'orgid',
      },
      {
        name: 'xbsj',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createdate',
      },
      {
        name: 'attendencesetupname',
      },
      {
        name: 'allowoutwork',
      },
      {
        name: 'enable',
      },
      {
        name: 'dkfs',
      },
      {
        name: 'attendencesetup',
        prop: 'attendencesetupid',
      },
      {
        name: 'sbsj',
      },
      {
        name: 'pimpersonname',
      },
      {
        name: 'vacholidayrulesname',
      },
      {
        name: 'porgid',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'pimpersonid',
      },
      {
        name: 'vacholidayrulesid',
      },
    ]
  }


}