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
        name: 'enable',
      },
      {
        name: 'ssou',
      },
      {
        name: 'salsalarybillname',
      },
      {
        name: 'salsalarybill',
        prop: 'salsalarybillid',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'createman',
      },
      {
        name: 'ormorgsectorname',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgsectorid',
      },
      {
        name: 'ormorgid',
      },
    ]
  }


}