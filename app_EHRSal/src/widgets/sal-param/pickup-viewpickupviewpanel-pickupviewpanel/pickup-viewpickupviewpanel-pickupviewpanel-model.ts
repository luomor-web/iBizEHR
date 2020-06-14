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
        name: 'updateman',
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
        name: 'param',
      },
      {
        name: 'salparam',
        prop: 'salparamid',
      },
      {
        name: 'salparamname',
      },
      {
        name: 'createdate',
      },
      {
        name: 'salsourcename',
      },
      {
        name: 'salsourceid',
      },
    ]
  }


}