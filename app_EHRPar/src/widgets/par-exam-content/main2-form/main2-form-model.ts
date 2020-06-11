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
        prop: 'parexamcontentid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parexamcontentname',
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
        name: 'contentcode',
        prop: 'contentcode',
        dataType: 'TEXT',
      },
      {
        name: 'parexamcontentname',
        prop: 'parexamcontentname',
        dataType: 'TEXT',
      },
      {
        name: 'parexamcontentid',
        prop: 'parexamcontentid',
        dataType: 'GUID',
      },
      {
        name: 'parexamcontent',
        prop: 'parexamcontentid',
        dataType: 'FONTKEY',
      },
    ]
  }

}