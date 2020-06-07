/**
 * ATTENDENCESETUPTree 部件模型
 *
 * @export
 * @class ATTENDENCESETUPTreeModel
 */
export default class ATTENDENCESETUPTreeModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof ATTENDENCESETUPTreeModel
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