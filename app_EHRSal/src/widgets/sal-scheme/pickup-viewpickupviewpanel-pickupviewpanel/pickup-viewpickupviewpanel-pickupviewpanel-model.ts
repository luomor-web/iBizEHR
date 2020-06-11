/**
 * PickupViewpickupviewpanel 部件模型
 *
 * @export
 * @class PickupViewpickupviewpanelModel
 */
export default class PickupViewpickupviewpanelModel {

  /**
    * 获取数据项集合
    *
    * @returns {any[]}
    * @memberof PickupViewpickupviewpanelModel
    */
  public getDataItems(): any[] {
    return [
      {
        name: 'createdate',
      },
      {
        name: 'saltype',
      },
      {
        name: 'memo',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createman',
      },
      {
        name: 'enable',
      },
      {
        name: 'salschemename',
      },
      {
        name: 'updateman',
      },
      {
        name: 'salscheme',
        prop: 'salschemeid',
      },
      {
        name: 'validflag',
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