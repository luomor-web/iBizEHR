/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'ormxmglid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'project_name',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ormxmglid',
        prop: 'ormxmglid',
        dataType: 'GUID',
      },
      {
        name: 'project_number',
        prop: 'project_number',
        dataType: 'TEXT',
      },
      {
        name: 'project_name',
        prop: 'project_name',
        dataType: 'TEXT',
      },
      {
        name: 'project_type',
        prop: 'project_type',
        dataType: 'TEXT',
      },
      {
        name: 'org_id',
        prop: 'org_id',
        dataType: 'TEXT',
      },
      {
        name: 'project_full_name',
        prop: 'project_full_name',
        dataType: 'TEXT',
      },
      {
        name: 'project_status_code',
        prop: 'project_status_code',
        dataType: 'TEXT',
      },
      {
        name: 'project_status_name',
        prop: 'project_status_name',
        dataType: 'TEXT',
      },
      {
        name: 'project_size',
        prop: 'project_size',
        dataType: 'TEXT',
      },
      {
        name: 'target_start_date',
        prop: 'target_start_date',
        dataType: 'TEXT',
      },
      {
        name: 'target_finish_date',
        prop: 'target_finish_date',
        dataType: 'TEXT',
      },
      {
        name: 'engineeringbustype',
        prop: 'engineeringbustype',
        dataType: 'SSCODELIST',
      },
      {
        name: 'engineeringpurpose',
        prop: 'engineeringpurpose',
        dataType: 'SSCODELIST',
      },
      {
        name: 'engineeringscale',
        prop: 'engineeringscale',
        dataType: 'SSCODELIST',
      },
      {
        name: 'isdirectlymanage',
        prop: 'isdirectlymanage',
        dataType: 'SSCODELIST',
      },
      {
        name: 'procapitalatt',
        prop: 'procapitalatt',
        dataType: 'SSCODELIST',
      },
      {
        name: 'ormxmgl',
        prop: 'ormxmglid',
        dataType: 'FONTKEY',
      },
    ]
  }

}