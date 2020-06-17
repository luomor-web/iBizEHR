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
        name: 'socruledetail',
        prop: 'socruledetailid',
      },
      {
        name: 'socruledetailname',
      },
      {
        name: 'createman',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'soctypeid',
      },
      {
        name: 'soctypename',
      },
      {
        name: 'socruleid',
      },
      {
        name: 'socrulename',
      },
      {
        name: 'highnum',
      },
      {
        name: 'lownum',
      },
      {
        name: 'companynum',
      },
      {
        name: 'personnum',
      },
      {
        name: 'companyrate',
      },
      {
        name: 'personrate',
      },
      {
        name: 'personamount',
      },
      {
        name: 'companyamount',
      },
      {
        name: 'memo',
      },
      {
        name: 'ordervalue',
      },
    ]
  }


}