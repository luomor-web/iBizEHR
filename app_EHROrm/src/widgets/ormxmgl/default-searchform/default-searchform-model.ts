/**
 * Default 部件模型
 *
 * @export
 * @class DefaultModel
 */
export default class DefaultModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof DefaultModel
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
        name: 'n_project_number_like',
        prop: 'project_number',
        dataType: 'TEXT',
      },
      {
        name: 'n_project_name_like',
        prop: 'project_name',
        dataType: 'TEXT',
      },
      {
        name: 'n_project_type_eq',
        prop: 'project_type',
        dataType: 'TEXT',
      },
    ]
  }

}