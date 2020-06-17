/**
 * Main2 部件模型
 *
 * @export
 * @class Main2Model
 */
export default class Main2Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main2Model
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
        prop: 'trmcoursesystemid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmcoursesystemname',
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
        name: 'dm',
        prop: 'dm',
        dataType: 'TEXT',
      },
      {
        name: 'trmcoursesystemname',
        prop: 'trmcoursesystemname',
        dataType: 'TEXT',
      },
      {
        name: 'dygx',
        prop: 'dygx',
        dataType: 'TEXT',
      },
      {
        name: 'jb',
        prop: 'jb',
        dataType: 'SSCODELIST',
      },
      {
        name: 'nr',
        prop: 'nr',
        dataType: 'TEXT',
      },
      {
        name: 'trmtrainagencyid',
        prop: 'trmtrainagencyid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmcoursesystemid',
        prop: 'trmcoursesystemid',
        dataType: 'GUID',
      },
      {
        name: 'trmcoursesystem',
        prop: 'trmcoursesystemid',
        dataType: 'FONTKEY',
      },
    ]
  }

}