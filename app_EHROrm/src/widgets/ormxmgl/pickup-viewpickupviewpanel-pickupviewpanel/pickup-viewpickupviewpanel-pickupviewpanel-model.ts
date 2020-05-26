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
        name: 'ehr_org_id',
      },
      {
        name: 'target_finish_date',
      },
      {
        name: 'isdirectlymanage',
      },
      {
        name: 'project_name',
      },
      {
        name: 'ormxmglname',
      },
      {
        name: 'engineeringbustype',
      },
      {
        name: 'project_type',
      },
      {
        name: 'project_status_code',
      },
      {
        name: 'project_status_name',
      },
      {
        name: 'createdate',
      },
      {
        name: 'updateman',
      },
      {
        name: 'engineeringscale',
      },
      {
        name: 'engineeringpurpose',
      },
      {
        name: 'project_size',
      },
      {
        name: 'ormxmgl',
        prop: 'ormxmglid',
      },
      {
        name: 'xmbh',
      },
      {
        name: 'project_full_name',
      },
      {
        name: 'org_id',
      },
      {
        name: 'procapitalatt',
      },
      {
        name: 'project_number',
      },
      {
        name: 'target_start_date',
      },
      {
        name: 'createman',
      },
      {
        name: 'updatedate',
      },
    ]
  }


}