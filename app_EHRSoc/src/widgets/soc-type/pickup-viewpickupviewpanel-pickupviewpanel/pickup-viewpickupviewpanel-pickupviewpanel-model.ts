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
        name: 'soctype',
        prop: 'soctypeid',
      },
      {
        name: 'soctypename',
      },
      {
        name: 'enable',
      },
      {
        name: 'createdate',
      },
      {
        name: 'createman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'ordervalue',
      },
    ]
  }


}