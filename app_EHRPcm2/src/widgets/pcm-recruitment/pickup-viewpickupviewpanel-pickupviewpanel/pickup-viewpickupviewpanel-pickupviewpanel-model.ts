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
        name: 'createman',
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
        name: 'pcmrecruitment',
        prop: 'pcmrecruitmentid',
      },
      {
        name: 'requirements',
      },
      {
        name: 'sjzprs',
      },
      {
        name: 'pcmrecruitmentname',
      },
      {
        name: 'yjzprs',
      },
      {
        name: 'sfzpwc',
      },
      {
        name: 'recruitmenttype',
      },
      {
        name: 'ormpostname',
      },
      {
        name: 'ormorgname',
      },
      {
        name: 'ormorgsectorname',
      },
      {
        name: 'ormdutyname',
      },
      {
        name: 'ormorgsectorid',
      },
      {
        name: 'ormorgid',
      },
      {
        name: 'ormpostid',
      },
      {
        name: 'ormdutyid',
      },
    ]
  }


}