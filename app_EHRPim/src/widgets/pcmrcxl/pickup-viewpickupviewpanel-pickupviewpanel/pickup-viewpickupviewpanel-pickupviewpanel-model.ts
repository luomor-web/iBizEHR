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
        name: 'updateman',
      },
      {
        name: 'code',
      },
      {
        name: 'updatedate',
      },
      {
        name: 'rcxlmc',
      },
      {
        name: 'pcmrcxl',
        prop: 'pcmrcxlid',
      },
      {
        name: 'snumber',
      },
      {
        name: 'rcxllx',
      },
      {
        name: 'pcmrcxlname',
      },
      {
        name: 'xldj',
      },
      {
        name: 'createman',
      },
      {
        name: 'pcmrcxlname2',
      },
      {
        name: 'pcmrcxlid2',
      },
    ]
  }


}