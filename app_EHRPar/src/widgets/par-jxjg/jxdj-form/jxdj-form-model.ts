/**
 * JXDJ 部件模型
 *
 * @export
 * @class JXDJModel
 */
export default class JXDJModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JXDJModel
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
        prop: 'parjxjgid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'parjxjgname',
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
        name: 'ygid',
        prop: 'ygid',
        dataType: 'TEXT',
      },
      {
        name: 'yg',
        prop: 'yg',
        dataType: 'TEXT',
      },
      {
        name: 'nd',
        prop: 'nd',
        dataType: 'SSCODELIST',
      },
      {
        name: 'khlx',
        prop: 'khlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'zz',
        prop: 'zz',
        dataType: 'TEXT',
      },
      {
        name: 'bm',
        prop: 'bm',
        dataType: 'TEXT',
      },
      {
        name: 'zf',
        prop: 'zf',
        dataType: 'FLOAT',
      },
      {
        name: 'khpgdj',
        prop: 'khpgdj',
        dataType: 'SSCODELIST',
      },
      {
        name: 'parjxjgid',
        prop: 'parjxjgid',
        dataType: 'GUID',
      },
      {
        name: 'parjxjg',
        prop: 'parjxjgid',
        dataType: 'FONTKEY',
      },
    ]
  }

}