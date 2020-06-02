/**
 * CurOrmorgPickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class CurOrmorgPickupViewpickupviewpanelModel
 */
export default class CurOrmorgPickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof CurOrmorgPickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'sbsj',
      },
      {
        name: 'xbsj',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'nd',
      },
      {
        name: 'updateman',
      },
      {
        name: 'vacholidayrulesname',
      },
      {
        name: 'sfqy',
      },
      {
        name: 'vacholidayrules',
        prop: 'vacholidayrulesid',
      },
      {
        name: 'orgid',
      },
      {
        name: 'tszxjzz',
      },
      {
        name: 'createdate',
      },
      {
        name: 'createman',
      },
      {
        name: 'defaultrule',
      },
      {
        name: 'orgcode',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgid',
      },
    ]
  }


}