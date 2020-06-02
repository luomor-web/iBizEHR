/**
 * KQYBTreeExpViewtreeexpbar 部件模型
 *
 * @export
 * @class KQYBTreeExpViewtreeexpbarModel
 */
export default class KQYBTreeExpViewtreeexpbarModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof KQYBTreeExpViewtreeexpbarModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'updatedate',
      },
      {
        name: 'attendancemreport',
        prop: 'attendancemreportid',
      },
      {
        name: 'attendancemreportname',
      },
      {
        name: 'createman',
      },
      {
        name: 'orgid',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'yf',
      },
      {
        name: 'enable',
      },
      {
        name: 'nd',
      },
      {
        name: 'zt',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'pimpersonname',
      },
      {
        name: 'pimpersonid',
      },
      {
        name: 'attendencesetupname',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'attendencesetupid',
      },
    ]
  }


}